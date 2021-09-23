import { ReactNode } from 'react';
import { ContainerDefault } from '../ContainerDefault';
import { ContentDefault } from '../ContentDefault';
import { HeaderContainer } from './styles';

type HeaderPros = {
  children?: ReactNode;
};

const HeaderDefault: React.FC<HeaderPros> = ({ children }) => {
  return (
    <HeaderContainer>
      <ContainerDefault>
        <ContentDefault>{children}</ContentDefault>
      </ContainerDefault>
    </HeaderContainer>
  );
};

export { HeaderDefault };
