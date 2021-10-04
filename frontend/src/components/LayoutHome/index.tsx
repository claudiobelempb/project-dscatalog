import { ReactNode } from 'react';
import { BrandDefault } from '../BrandDefault';
import { FooterDefault } from '../FooterDefault';
import { NavDefault } from '../NavDefault';
import { HeaderDefault } from '../HeaderDefault';
import { MainDefault } from '../MainDefault';
import { ContentDefault } from '../ContentDefault';
import { mock } from '../NavDefault/mock';
import { ButtonDefault } from '../ButtonDefault';
import { HeadingDefault } from '../HeadingDefault';
import { LayoutHomeContainer } from './styles';
import { ContainerDefault } from '../ContainerDefault';
import { GridDefault } from '../GridDefault';
import { InputDefault } from '../InputDefault';
import { LinkDefault } from '../LinkDefault';

const ImgBrand = '/images/brand.svg';

type LayoutHomeProps = {
  children?: ReactNode;
};

const LayoutHome: React.FC<LayoutHomeProps> = ({ children }) => {
  return (
    <LayoutHomeContainer>
      <HeaderDefault>
        <GridDefault size={3}>
          <BrandDefault src={ImgBrand} />
          <InputDefault
            InputOnClick={() => console.log('Click')}
            icon
            placeholder={'Search...'}
            InputOnChange={() => alert('Onchance')}
          />
          {/* <NavDefault links={mock} /> */}
          <NavDefault>
            <LinkDefault href={'/'} title={'Home'}></LinkDefault>
            <LinkDefault href={'/admin'} title={'Admin'}></LinkDefault>
            {/* <LinkDefault links={mock}/> */}
          </NavDefault>
        </GridDefault>
      </HeaderDefault>
      <MainDefault>{children}</MainDefault>
      {/* <FooterDefault>
        <h1>Footer</h1>
      </FooterDefault> */}
    </LayoutHomeContainer>
  );
};

export { LayoutHome };
