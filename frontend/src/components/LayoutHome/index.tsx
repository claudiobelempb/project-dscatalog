import React from 'react';
import { Brand } from '../../components/Brand';
import { Footer } from '../../components/Footer';
import { Nav } from '../../components/Nav';
import { Header } from '../../components/Header';
import { Main } from '../../components/Main';
import { Content } from '../../components/Content';
import { mock } from '../../components/Nav/mock';
import { Button } from '../Button';
import { Heading } from '../Heading';
import { LayoutHomeContainer } from './styles';
import { Container } from '../Container';

const ImgBrand = '/images/brand.svg';

type LayoutHomeProps = {
  children?: React.ReactNode;
  title?: string;
};

const LayoutHome: React.FC<LayoutHomeProps> = ({ children, title }) => {
  return (
    <LayoutHomeContainer>
      <Header>
        <div className={'grid-2'}>
          <Brand src={ImgBrand} />
          <Nav links={mock} />
        </div>
      </Header>
      <Main>{children}</Main>
      {/* <Footer>
        <h1>Footer</h1>
      </Footer> */}
    </LayoutHomeContainer>
  );
};

export { LayoutHome };
