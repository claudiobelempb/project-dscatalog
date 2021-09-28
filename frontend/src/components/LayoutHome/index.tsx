import React from 'react';
import { BrandDefault } from '../BrandDefault';
import { FooterDefault } from '../FooterDefault';
import { Nav } from '../../components/Nav';
import { HeaderDefault } from '../HeaderDefault';
import { MainDefault } from '../MainDefault';
import { ContentDefault } from '../ContentDefault';
import { mock } from '../../components/Nav/mock';
import { ButtonDefault } from '../ButtonDefault';
import { HeadingDefault } from '../HeadingDefault';
import { LayoutHomeContainer } from './styles';
import { ContainerDefault } from '../ContainerDefault';
import { GridDefault } from '../GridDefault';
import { InputDefault } from '../InputDefault';

const ImgBrand = '/images/brand.svg';
const ImgSearch = '/images/btn-search.svg';

type LayoutHomeProps = {
  children?: React.ReactNode;
  title?: string;
};

const LayoutHome: React.FC<LayoutHomeProps> = ({ children, title }) => {
  return (
    <LayoutHomeContainer>
      <HeaderDefault>
        <GridDefault size={3}>
          <BrandDefault src={ImgBrand} />
          <InputDefault
            src={ImgSearch}
            onClick={() => console.log('Click')}
            icon
            placeholder={'Search...'}
            onChange={() => alert('Onchance')}
          />
          <Nav links={mock} />
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
